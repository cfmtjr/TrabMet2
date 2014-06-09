package metodopassovariavel;

import java.math.BigDecimal;

/**
 *
 * @author Alessandro Campello Silva,<p>
 * Carlos Filipe M. Teixeira Jr.,<p>
 * Thadeu José Caldas Neves,<p>
 * Tomas M.G. de Siqueira.
 */
public interface IFuncao {
    public BigDecimal calcula(BigDecimal x, BigDecimal y);
    public BigDecimal calculaAlfa(double ini);
    @Override
    public String toString();
}
