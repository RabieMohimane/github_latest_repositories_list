package com.rabie.githublatestrepositories.data.models

data class RepositoriesWrapper(
    var incomplete_results: Boolean = false,
    var items: List<Item> = listOf(),
    var total_count: Int = 0
)