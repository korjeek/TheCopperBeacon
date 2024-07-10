package net.korjeek.copperbeaconsmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperBeaconsMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("copperbeaconsmod");

	@Override
	public void onInitialize() {
		LOGGER.info("Mod initialization...");
	}
}