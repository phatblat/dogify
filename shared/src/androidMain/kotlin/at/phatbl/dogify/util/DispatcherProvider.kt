package at.phatbl.dogify.util

import kotlinx.coroutines.Dispatchers

private class AndroidDispatcherProvider : DispatcherProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
    override val unconfined = Dispatchers.Unconfined
}

internal actual fun getDispatcherProvider(): DispatcherProvider = AndroidDispatcherProvider()
