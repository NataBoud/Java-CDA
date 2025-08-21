package org.example.PKComposed;

import lombok.experimental.ExtensionMethod;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CommandePK implements Serializable {
    private int numerosCommande;
    private int codeDeCommande;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CommandePK that = (CommandePK) o;
        return numerosCommande == that.numerosCommande && codeDeCommande == that.codeDeCommande;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerosCommande, codeDeCommande);
    }
}
