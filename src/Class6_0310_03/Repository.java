package Class6_0310_03;

import java.util.Optional;

public interface Repository <K, E> {
    void save(E entity);

    Optional<E> getEntityById(K id);
}

/*
interface genérica parametrizável quanto ao tipo da chave e da
entidade persistida. A interface deve prover um método para salvar uma
entidade e outro para obter a entidade pelo id
 */
