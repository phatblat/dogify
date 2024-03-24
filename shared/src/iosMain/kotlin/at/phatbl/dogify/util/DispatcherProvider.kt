package at.phatbl.dogify.util

import kotlinx.coroutines.Dispatchers

private class IosDispatcherProvider : DispatcherProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.Default
    override val unconfined = Dispatchers.Unconfined
}

internal actual fun getDispatcherProvider(): DispatcherProvider = IosDispatcherProvider()
