package com.vimeo.networking2

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.vimeo.networking2.common.Entity
import java.util.Date

/**
 * A representation of the status of any attempts to upload/post a video to a
 * third-party social network at a specific time.
 *
 * @param firstPublishDate The time in ISO 8601 format when the user first attempted to publish a clip to third-party
 * social networks.
 * @param destinations Contains information about upload/post status on all third party social networks.
 * @param resourceKey The resource key string of the PublishJob.
 */
@JsonClass(generateAdapter = true)
data class PublishJob(

    @Json(name = "first_publish_date")
    val firstPublishDate: Date? = null,

    @Json(name = "destinations")
    val destinations: PublishJobDestinations? = null,

    @Json(name = "resource_key")
    val resourceKey: String? = null

) : Entity {
    override val identifier: String? = resourceKey
}
