package com.vimeo.networking2

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.vimeo.networking2.common.Entity
import com.vimeo.networking2.enums.PlaylistSortType
import com.vimeo.networking2.enums.asEnum

/**
 * Live Event data.
 * @param autoCCKeywords A comma-separated list of keywords for enhancing the speech detection of automated closed
 * captions.
 * @param autoCCLanguage The language of the Automated Closed Captions.
 * @param autoCCRemaining The amount of time remaining to the user to access the Automated Closed Captions feature.
 * @param contentRating The event's granular content ratings. Current values are:
 * - 'unrated' - The event hasn't been rated.
 * - 'safe' - The event is safe for all audiences.
 * - 'advertisement' - The event contains advertisements.
 * - 'drugs' - The event contains drug or alcohol use.
 * - 'language' - The event contains profanity or sexually suggestive content.
 * - 'nudity' - The event contains nudity.
 * - 'violence' - The event contains violence.
 * @param createdTime The time in ISO 8601 format when the live event was created.
 * @param dashLink The upstream MPEG-DASH link. To create a live video on the event, send your live content
 * to this link.
 * @param embed The live event's embed data.
 * @param firstVideoInPlaylist The first video to be played in the playlist.
 * @param isAutoCCEnabled Whether the Automated Closed Captions feature is enabled.
 * @param isChatEnabled Whether to display live chat on the event page on Vimeo.
 * @param isFromShowcase Whether the live event was created from a showcase.
 * @param isFromWebinar Whether the live event was created from a webinar.
 * @param isLowLatencyEnabled Whether the low latency feature is enabled.
 * @param isUnlimitedStreamingEnabled Whether 24/7 streaming is enabled for the event.
 * @param link The URI to access the live event on Vimeo.
 * @param liveClips A list of videos belonging to the live event, including their video IDs and dates streamed.
 * @param metadata Metadata about the live event.
 * @param nextOccurrenceTime The ISO 8601 date on which the next occurrence of the event is expected to be live.
 * @param parentFolder Information about the folder that contains the event.
 * @param pictures The active thumbnail image of the live event.
 * @param playlistSort The order in which the videos inside the live event appear in the playlist.
 * @param rtmpLink The upstream RTMP link. Send your live content to this link to create a live video on the event.
 * @param rtmpsLink The upstream RTMPS link. Send your live content to this link to create a live video on the event.
 * @param shouldAutomaticallyTitleStream When the value of this field is true, the title for the next video in the event
 * is generated based on the time of the stream and the title field of the event.
 * @param shouldIgnoreAutoCCTimeLimit Whether to ignore the time limit of the Automated Closed Captions feature.
 * @param streamDescription The description of the next video streamed to the event.
 * @param streamKey The stream key used in conjunction with the RTMP and RTMPS links.
 * @param streamPassword Anyone with the password can access the videos generated by streaming to the event.
 * @param streamPrivacy The initial privacy settings of videos generated by streaming to the event
 * as well as the embed privacy of the entire collection.
 * @param streamTitle The title of the next video streamed to the event.
 * This field applies only when [shouldAutomaticallyTitleStream] is `false`.
 * @param streamableVideo The live event's video. A recurring live event always has a video,
 * which is either in a pre-live state (ready to be streamed to) or in a live state
 * (which is currently being streamed to).
 * @param timeZone The time zone used in resolving the timestamps included in auto-generated video titles.
 * @param title The title of the live event. This field is also optionally used as the base title for videos
 * created by streaming to the event.
 * @param uri The live event's canonical relative URI.
 * @param user The owner of the live event.
 */
@JsonClass(generateAdapter = true)
data class LiveEvent(

//    @Json(name = "auto_cc_keywords")
//    val autoCCKeywords: String? = null,
//
//    @Json(name = "auto_cc_language")
//    val autoCCLanguage: String? = null,
//
//    @Json(name = "auto_cc_remaining")
//    val autoCCRemaining: Double? = null,
//
//    @Json(name = "content_rating")
//    val contentRating: List<String>? = null,
//
//    @Json(name = "created_time")
//    val createdTime: Date? = null,
//
//    @Json(name = "dash_link")
//    val dashLink: String? = null,
//
//    @Json(name = "embed")
//    val embed: LiveEventEmbed? = null,
//
//    @Json(name = "head_clip")
//    val firstVideoInPlaylist: Video? = null,
//
//    @Json(name = "auto_cc_enabled")
//    val isAutoCCEnabled: Boolean? = null,
//
//    @Json(name = "chat_enabled")
//    val isChatEnabled: Boolean? = null,
//
//    @Json(name = "from_showcase")
//    val isFromShowcase: Boolean? = null,
//
//    @Json(name = "from_webinar")
//    val isFromWebinar: Boolean? = null,
//
//    @Json(name = "low_latency")
//    val isLowLatencyEnabled: Boolean? = null,
//
//    @Json(name = "unlimited_duration")
//    val isUnlimitedStreamingEnabled: Boolean? = null,
//
//    @Json(name = "link")
//    val link: String? = null,
//
//    @Json(name = "live_clips")
//    val liveClips: List<Video>? = null,
//
//    @Json(name = "metadata")
//    val metadata: Metadata<LiveEventConnections, LiveEventInteractions>? = null,
//
//    @Json(name = "next_occurrence_time")
//    val nextOccurrenceTime: Date? = null,
//
//    @Json(name = "parent_folder")
//    val parentFolder: Folder? = null,
//
//    @Json(name = "pictures")
//    val pictures: PictureCollection? = null,
//
    @Json(name = "playlist_sort")
    val playlistSort: String? = null,
//
//    @Json(name = "rtmp_link")
//    val rtmpLink: String? = null,
//
//    @Json(name = "rtmps_link")
//    val rtmpsLink: String? = null,
//
//    @Json(name = "automatically_title_stream")
//    val shouldAutomaticallyTitleStream: Boolean? = null,
//
//    @Json(name = "unlimited_auto_cc")
//    val shouldIgnoreAutoCCTimeLimit: Boolean? = null,
//
//    @Json(name = "stream_description")
//    val streamDescription: String? = null,
//
//    @Json(name = "stream_key")
//    val streamKey: String? = null,
//
//    @Json(name = "stream_password")
//    val streamPassword: String? = null,
//
//    @Json(name = "stream_privacy")
//    val streamPrivacy: StreamPrivacy? = null,
//
//    @Json(name = "stream_title")
//    val streamTitle: String? = null,

    @Json(name = "streamable_clip")
    val streamableVideo: Video? = null,

    @Json(name = "time_zone")
    val timeZone: String? = null,

    @Json(name = "title")
    val title: String? = null,

    @Json(name = "uri")
    val uri: String? = null,

    @Json(name = "user")
    val user: User? = null

) : Entity {
    override val identifier: String? = uri
}

/**
 * @see LiveEvent.playlistSort
 * @see PlaylistSortType
 */
val LiveEvent.playlistSortType: PlaylistSortType
    get() = playlistSort.asEnum(PlaylistSortType.UNKNOWN)
