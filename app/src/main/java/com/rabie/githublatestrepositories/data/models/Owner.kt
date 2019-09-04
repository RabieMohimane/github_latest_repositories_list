package com.rabie.githublatestrepositories.data.models

import android.os.Parcel
import android.os.Parcelable

data class Owner(
    var avatar_url: String? = "",
    var events_url: String? = "",
    var followers_url: String? = "",
    var following_url: String? = "",
    var gists_url: String? = "",
    var gravatar_id: String? = "",
    var html_url: String? = "",
    var id: Int = 0,
    var login: String? = "",
    var node_id: String? = "",
    var organizations_url: String? = "",
    var received_events_url: String? = "",
    var repos_url: String? = "",
    var site_admin: Boolean? = false,
    var starred_url: String? = "",
    var subscriptions_url: String? = "",
    var type: String? = "",
    var url: String? = ""
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatar_url)
        parcel.writeString(events_url)
        parcel.writeString(followers_url)
        parcel.writeString(following_url)
        parcel.writeString(gists_url)
        parcel.writeString(gravatar_id)
        parcel.writeString(html_url)
        parcel.writeInt(id)
        parcel.writeString(login)
        parcel.writeString(node_id)
        parcel.writeString(organizations_url)
        parcel.writeString(received_events_url)
        parcel.writeString(repos_url)
        parcel.writeValue(site_admin)
        parcel.writeString(starred_url)
        parcel.writeString(subscriptions_url)
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Owner> {
        override fun createFromParcel(parcel: Parcel): Owner {
            return Owner(parcel)
        }

        override fun newArray(size: Int): Array<Owner?> {
            return arrayOfNulls(size)
        }
    }
}