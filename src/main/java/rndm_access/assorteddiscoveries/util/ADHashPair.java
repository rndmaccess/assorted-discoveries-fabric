package rndm_access.assorteddiscoveries.util;

import com.google.common.base.Objects;

public class ADHashPair<L, R> {
    private final L left;
    private final R right;

    public ADHashPair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ADHashPair<?, ?> other)) {
            return false;
        } else {
            return Objects.equal(left, other.left) && Objects.equal(right, other.right);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(left, right);
    }
}
