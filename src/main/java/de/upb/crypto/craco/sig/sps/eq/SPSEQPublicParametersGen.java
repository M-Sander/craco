package de.upb.crypto.craco.sig.sps.eq;

import de.upb.crypto.math.pairings.counting.CountingBilinearGroup;
import de.upb.crypto.math.pairings.generic.BilinearGroup;
import de.upb.crypto.math.pairings.type3.bn.BarretoNaehrigBilinearGroupImpl;
import de.upb.crypto.math.structures.groups.lazy.LazyBilinearGroup;

import java.util.Arrays;

public class SPSEQPublicParametersGen {
    /**
     * @param securityParameter The security parameter.
     * @param debugMode         Enable debug mode (Makes the PPs insecure!).
     * @return The public parameters for the Pointcheval Sanders signature scheme
     */
    public SPSEQPublicParameters generatePublicParameter(int securityParameter, boolean debugMode) {
        BilinearGroup group;
        if (debugMode) {
            group = new CountingBilinearGroup(securityParameter, BilinearGroup.Type.TYPE_3);
        } else {
            group = new LazyBilinearGroup(new BarretoNaehrigBilinearGroupImpl(securityParameter));
        }

        return new SPSEQPublicParameters(group);
    }
}
