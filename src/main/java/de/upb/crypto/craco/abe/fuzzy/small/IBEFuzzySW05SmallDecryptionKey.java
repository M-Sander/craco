package de.upb.crypto.craco.abe.fuzzy.small;

import de.upb.crypto.craco.interfaces.DecryptionKey;
import de.upb.crypto.craco.interfaces.abe.SetOfAttributes;
import de.upb.crypto.math.interfaces.structures.GroupElement;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.annotations.v2.ReprUtil;
import de.upb.crypto.math.serialization.annotations.v2.Represented;

import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;

/**
 * The {@link DecryptionKey} for the {@link IBEFuzzySW05Small}.
 * <p>
 * This key is generated by
 * {@link IBEFuzzySW05Small#generateDecryptionKey(de.upb.crypto.craco.interfaces.pe.MasterSecret,
 *                                                de.upb.crypto.craco.interfaces.pe.KeyIndex)}
 * .
 *
 * @author Mirko Jürgens
 */
public class IBEFuzzySW05SmallDecryptionKey implements DecryptionKey {

    @Represented
    private SetOfAttributes identity;

    @Represented(restorer = "foo -> G1")
    private Map<BigInteger, GroupElement> d;

    public IBEFuzzySW05SmallDecryptionKey(SetOfAttributes id, Map<BigInteger, GroupElement> d) {
        this.identity = id;
        this.d = d;
    }

    public IBEFuzzySW05SmallDecryptionKey(Representation repr, IBEFuzzySW05SmallPublicParameters kpp) {
        new ReprUtil(this).register(kpp.getGroupG1(), "G1").deserialize(repr);
    }

    @Override
    public Representation getRepresentation() {
        return ReprUtil.serialize(this);
    }

    public SetOfAttributes getIdentity() {
        return identity;
    }

    public Map<BigInteger, GroupElement> getD() {
        return d;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((d == null) ? 0 : d.hashCode());
        result = prime * result + ((identity == null) ? 0 : identity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IBEFuzzySW05SmallDecryptionKey other = (IBEFuzzySW05SmallDecryptionKey) obj;
        return Objects.equals(d, other.d)
                && Objects.equals(identity, other.identity);
    }

}
