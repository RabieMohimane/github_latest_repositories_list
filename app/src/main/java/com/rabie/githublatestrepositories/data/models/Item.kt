package com.rabie.githublatestrepositories.data.models

import android.os.Parcel
import android.os.Parcelable

data class Item(
    var `private`: Boolean = false,
    var archive_url: String? = "",
    var archived: Boolean = false,
    var assignees_url: String? = "",
    var blobs_url: String? = "",
    var branches_url: String? = "",
    var clone_url: String? = "",
    var collaborators_url: String? = "",
    var comments_url: String? = "",
    var commits_url: String? = "",
    var compare_url: String? = "",
    var contents_url: String? = "",
    var contributors_url: String? = "",
    var created_at: String? = "",
    var default_branch: String? = "",
    var deployments_url: String? = "",
    var description: String? = "",
    var disabled: Boolean = false,
    var downloads_url: String? = "",
    var events_url: String? = "",
    var fork: Boolean = false,
    var forks: Int = 0,
    var forks_count: Int = 0,
    var forks_url: String? = "",
    var full_name: String? = "",
    var git_commits_url: String? = "",
    var git_refs_url: String? = "",
    var git_tags_url: String? = "",
    var git_url: String? = "",
    var has_downloads: Boolean = false,
    var has_issues: Boolean = false,
    var has_pages: Boolean = false,
    var has_projects: Boolean = false,
    var has_wiki: Boolean = false,
    var homepage: String? = "",
    var hooks_url: String? = "",
    var html_url: String? = "",
    var id: Int = 0,
    var issue_comment_url: String? = "",
    var issue_events_url: String? = "",
    var issues_url: String? = "",
    var keys_url: String? = "",
    var labels_url: String? = "",
    var language: String? = "",
    var languages_url: String? = "",
    var license: License? = License(),
    var merges_url: String? = "",
    var milestones_url: String? = "",
    var mirror_url: String? = "",
    var name: String? = "",
    var node_id: String? = "",
    var notifications_url: String? = "",
    var open_issues: Int = 0,
    var open_issues_count: Int = 0,
    var owner: Owner = Owner(),
    var pulls_url: String? = "",
    var pushed_at: String? = "",
    var releases_url: String? = "",
    var score: Double = 0.0,
    var size: Int = 0,
    var ssh_url: String? = "",
    var stargazers_count: Int = 0,
    var stargazers_url: String? = "",
    var statuses_url: String? = "",
    var subscribers_url: String? = "",
    var subscription_url: String? = "",
    var svn_url: String? = "",
    var tags_url: String? = "",
    var teams_url: String? = "",
    var trees_url: String? = "",
    var updated_at: String? = "",
    var url: String? = "",
    var watchers: Int = 0,
    var watchers_count: Int = 0
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(License::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(Owner::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (private) 1 else 0)
        parcel.writeString(archive_url)
        parcel.writeByte(if (archived) 1 else 0)
        parcel.writeString(assignees_url)
        parcel.writeString(blobs_url)
        parcel.writeString(branches_url)
        parcel.writeString(clone_url)
        parcel.writeString(collaborators_url)
        parcel.writeString(comments_url)
        parcel.writeString(commits_url)
        parcel.writeString(compare_url)
        parcel.writeString(contents_url)
        parcel.writeString(contributors_url)
        parcel.writeString(created_at)
        parcel.writeString(default_branch)
        parcel.writeString(deployments_url)
        parcel.writeString(description)
        parcel.writeByte(if (disabled) 1 else 0)
        parcel.writeString(downloads_url)
        parcel.writeString(events_url)
        parcel.writeByte(if (fork) 1 else 0)
        parcel.writeInt(forks)
        parcel.writeInt(forks_count)
        parcel.writeString(forks_url)
        parcel.writeString(full_name)
        parcel.writeString(git_commits_url)
        parcel.writeString(git_refs_url)
        parcel.writeString(git_tags_url)
        parcel.writeString(git_url)
        parcel.writeByte(if (has_downloads) 1 else 0)
        parcel.writeByte(if (has_issues) 1 else 0)
        parcel.writeByte(if (has_pages) 1 else 0)
        parcel.writeByte(if (has_projects) 1 else 0)
        parcel.writeByte(if (has_wiki) 1 else 0)
        parcel.writeString(homepage)
        parcel.writeString(hooks_url)
        parcel.writeString(html_url)
        parcel.writeInt(id)
        parcel.writeString(issue_comment_url)
        parcel.writeString(issue_events_url)
        parcel.writeString(issues_url)
        parcel.writeString(keys_url)
        parcel.writeString(labels_url)
        parcel.writeString(language)
        parcel.writeString(languages_url)
        parcel.writeParcelable(license, flags)
        parcel.writeString(merges_url)
        parcel.writeString(milestones_url)
        parcel.writeString(mirror_url)
        parcel.writeString(name)
        parcel.writeString(node_id)
        parcel.writeString(notifications_url)
        parcel.writeInt(open_issues)
        parcel.writeInt(open_issues_count)
        parcel.writeParcelable(owner, flags)
        parcel.writeString(pulls_url)
        parcel.writeString(pushed_at)
        parcel.writeString(releases_url)
        parcel.writeDouble(score)
        parcel.writeInt(size)
        parcel.writeString(ssh_url)
        parcel.writeInt(stargazers_count)
        parcel.writeString(stargazers_url)
        parcel.writeString(statuses_url)
        parcel.writeString(subscribers_url)
        parcel.writeString(subscription_url)
        parcel.writeString(svn_url)
        parcel.writeString(tags_url)
        parcel.writeString(teams_url)
        parcel.writeString(trees_url)
        parcel.writeString(updated_at)
        parcel.writeString(url)
        parcel.writeInt(watchers)
        parcel.writeInt(watchers_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}