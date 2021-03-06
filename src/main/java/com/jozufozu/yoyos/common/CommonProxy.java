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

package com.jozufozu.yoyos.common;

import com.jozufozu.yoyos.Yoyos;
import com.jozufozu.yoyos.compat.EntityChaserYoyo;
import com.jozufozu.yoyos.network.YoyoNetwork;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Yoyos.MODID, "yoyo"), EntityYoyo.class, "YoYo", 0, Yoyos.INSTANCE, 64, 4, false);
        EntityRegistry.registerModEntity(new ResourceLocation(Yoyos.MODID, "yoyo_sticky"), EntityStickyYoyo.class, "Sticky_YoYo", 1, Yoyos.INSTANCE, 64, 4, true);
        //EntityRegistry.registerModEntity(new ResourceLocation(Yoyos.MODID, "yoyo_anything"), EntityArbitraryYoyo.class, "Anything_YoYo", 2, Yoyos.INSTANCE, 64, 4, true);
        EntityRegistry.registerModEntity(new ResourceLocation(Yoyos.MODID, "yoyo_chaser"), EntityChaserYoyo.class, "Anything_YoYo", 3, Yoyos.INSTANCE, 64, 4, true);
    }
    
    public void init(FMLInitializationEvent event)
    {
        YoyoNetwork.initialize();
    }
    
    public boolean runningOnClient()
    {
        return false;
    }
}
