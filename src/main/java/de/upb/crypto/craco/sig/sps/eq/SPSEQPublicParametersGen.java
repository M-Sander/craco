package de.upb.crypto.craco.sig.sps.eq;

import de.upb.crypto.math.factory.BilinearGroup;
import de.upb.crypto.math.factory.BilinearGroupFactory;
import de.upb.crypto.math.interfaces.mappings.BilinearMap;
import de.upb.crypto.math.pairings.bn.BarretoNaehrigProvider;

import java.util.Arrays;

public class SPSEQPublicParametersGen {
    /**
     * @param securityParameter The security parameter.
     * @param debugMode         Enable debug mode (Makes the PPs insecure!).
     * @return The public parameters for the Pointcheval Sanders signature scheme
     */
    public SPSEQPublicParameters generatePublicParameter(int securityParameter, boolean debugMode) {
        // Get bilinear group from the factory
        BilinearGroupFactory fac = new BilinearGroupFactory(securityParameter);
        fac.setDebugMode(debugMode);
        fac.setRequirements(BilinearGroup.Type.TYPE_3);
        fac.registerProvider(Arrays.asList(
                // new ECCelerateBilinearGroupProvider(), //not yet publicly available
                // new BarretoNaehrigNativeProvider(), //not yet publicly available
                new BarretoNaehrigProvider()));
        BilinearGroup group = fac.createBilinearGroup();

        return new SPSEQPublicParameters(group);
    }
}
