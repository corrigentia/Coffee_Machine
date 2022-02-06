private const val REDDIT_CREATED = 2005

data class Site(val address: String, val foundationYear: Int)

// Write the makeReddit function here
fun makeReddit() = Site("reddit.com", REDDIT_CREATED)
