/*
 * Copyright (c) 2018 Jozsef Augusztiny
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

package com.jozufozu.yoyos.network

import com.jozufozu.yoyos.common.YoyoEntity
import com.jozufozu.yoyos.compat.botania.ChaserYoyoEntity
import net.minecraft.network.PacketBuffer
import net.minecraftforge.fml.network.NetworkEvent
import java.util.function.Supplier

class SAcquireTargetPacket() {
    constructor(buf: PacketBuffer): this()

    fun encode(buf: PacketBuffer) {}

    fun onMessage(ctx: Supplier<NetworkEvent.Context>) {
        ctx.get().enqueueWork {
            val player = ctx.get().sender ?: return@enqueueWork

            val maybeYoyo = YoyoEntity.CASTERS[player.uniqueID]

            if (maybeYoyo is ChaserYoyoEntity) {
                maybeYoyo.acquireTargetEntity()
            }
        }

        ctx.get().packetHandled = true
    }
}