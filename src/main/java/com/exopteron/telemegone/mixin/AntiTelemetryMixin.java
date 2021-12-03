package com.exopteron.telemegone.mixin;

import com.exopteron.telemegone.Telemegone;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.util.telemetry.TelemetrySender;

@Mixin(TelemetrySender.class)
public class AntiTelemetryMixin {
    @Inject(method = "send", at = @At("HEAD"), cancellable = true)
    private void send(TelemetrySender.PlayerGameMode gamemode, CallbackInfo c) {
        Telemegone.LOGGER.info("Telemetry send was blocked.");
        c.cancel();
    }
}
