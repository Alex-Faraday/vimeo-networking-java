/*
 * Copyright (c) 2020 Vimeo (https://vimeo.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.vimeo.networking2

import com.vimeo.networking2.VimeoResponse.Error
import com.vimeo.networking2.VimeoResponse.Success

/**
 * Result of the API response. [Success] contains the data while the [Error] class will
 * inform you of an api error.
 *
 * @param httpStatusCode HTTP status code.
 */
sealed class VimeoResponse<out T>(open val httpStatusCode: Int) {

    /**
     * A successful response.
     *
     * @param data The parsed data for the request.
     * @param responseOrigin The origin of the response.
     * @param httpStatusCode HTTP status code.
     */
    data class Success<T>(
        val data: T,
        val responseOrigin: ResponseOrigin = ResponseOrigin.NETWORK,
        override val httpStatusCode: Int
    ) : VimeoResponse<T>(httpStatusCode)

    /**
     * An error occurred when making the request. This error may be due to invalid parameters,
     * exception thrown when making the request or there was an error parsing the response.
     *
     * @param message The error message.
     * @param httpStatusCode HTTP status code.
     */
    sealed class Error(val message: String, override val httpStatusCode: Int) : VimeoResponse<Nothing>(httpStatusCode) {

        /**
         * The Vimeo API returned an error response for the request you made.
         *
         * This error type provides an instance of an [ApiError] and is parsed from the error response of a network
         * request. Occasionally, the library creates internal instances of this error itself in order to eagerly catch
         * issues, such as when a parameter wrongly provided. In cases where the response is from the API, the
         * [httpStatusCode] will provide the appropriate status code, otherwise local errors will populate it with
         * [ApiConstants.NONE].
         *
         * @param reason Info on the error.
         * @param httpStatusCode HTTP status code, [ApiConstants.NONE] if not applicable or if the error was
         * created locally.
         */
        data class Api(
            val reason: ApiError,
            override val httpStatusCode: Int
        ) : Error("API error: ${reason.errorCode ?: NA}", httpStatusCode)

        /**
         * The Vimeo API returned a fatal error that indicates that the token used to make the request is invalid. The
         * token should be discarded and a new token should be acquired. Further requests should not be made with the
         * token.
         *
         * @param reason Info on the error.
         * @param httpStatusCode HTTP status code, [ApiConstants.NONE] if not applicable or if the error was
         * created locally.
         */
        data class InvalidToken(
            val reason: ApiError?,
            override val httpStatusCode: Int
        ) : Error("Unauthorized error: ${reason?.errorCode ?: NA}", httpStatusCode)

        /**
         * An exception was thrown when making the request, e.g. the internet connection failed and a
         * [java.io.IOException] is thrown. This should only be used if a response was not received from the server. If
         * a response is received from the server, an [Api] should be created instead, or if one cannot be parsed, an
         * [Unknown]. In the case of an exception being thrown, we haven't received a response from the API, so the
         * [httpStatusCode] will always be set to [ApiConstants.NONE].
         *
         * @param throwable Info on the exception that was thrown.
         */
        data class Exception(
            val throwable: Throwable
        ) : Error("Exception: ${throwable.javaClass} - ${throwable.message ?: NA}", ApiConstants.NONE)

        /**
         * An unknown error occurred.
         *
         * This error type is reserved for cases that don't fall into either the [Api] case or the [Exception] case.
         * This error will be used if the response should result in an [Api] error and no exception was thrown, but we
         * were unable to parse the error response correctly. This type should never be created by the consumer as it
         * requires the response for debugging. The raw response will allow the consumer to see info about the request.
         *
         * @param rawResponse Raw response from the API.
         * @param httpStatusCode HTTP status code, [ApiConstants.NONE] if not applicable or if the error was
         * created locally.
         */
        data class Unknown(
            val rawResponse: String,
            override val httpStatusCode: Int
        ) : Error("Unknown error: $httpStatusCode", httpStatusCode)
    }

    companion object {

        private const val NA = "N/A"
    }
}
