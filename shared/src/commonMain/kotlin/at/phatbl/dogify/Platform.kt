package at.phatbl.dogify

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform