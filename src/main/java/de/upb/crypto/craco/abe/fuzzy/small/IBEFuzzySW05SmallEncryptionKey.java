package de.upb.crypto.craco.abe.fuzzy.small;

import de.upb.crypto.craco.abe.interfaces.SetOfAttributes;
import de.upb.crypto.craco.common.interfaces.EncryptionKey;
import de.upb.crypto.craco.common.interfaces.pe.CiphertextIndex;
import de.upb.crypto.math.interfaces.hash.ByteAccumulator;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.annotations.v2.ReprUtil;
import de.upb.crypto.math.serialization.annotations.v2.Represented;

import java.util.Objects;

/**
 * The {@link EncryptionKey} for the {@link IBEFuzzySW05Small}.
 * <p>
 * This Key is generated by
 * {@link IBEFuzzySW05Small#generateEncryptionKey(CiphertextIndex)}.
 *
 * @author Mirko Jürgens
 */
public class IBEFuzzySW05SmallEncryptionKey implements EncryptionKey {

    @Represented
    SetOfAttributes identity;

    public IBEFuzzySW05SmallEncryptionKey(SetOfAttributes id) {
        this.identity = id;
    }

    public IBEFuzzySW05SmallEncryptionKey(Representation repr) {
        new ReprUtil(this).deserialize(repr);
    }

    @Override
    public Representation getRepresentation() {
        return ReprUtil.serialize(this);
    }

    public SetOfAttributes getIdentity() {
        return identity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        IBEFuzzySW05SmallEncryptionKey other = (IBEFuzzySW05SmallEncryptionKey) obj;
        return Objects.equals(identity, other.identity);
    }

    @Override
    public ByteAccumulator updateAccumulator(ByteAccumulator accumulator) {
        return identity.updateAccumulator(accumulator);
    }

}
