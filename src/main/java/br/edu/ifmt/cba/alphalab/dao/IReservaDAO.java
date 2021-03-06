package br.edu.ifmt.cba.alphalab.dao;

import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;

/**
 * 
 * @author StÚvillis Sousa
 *
 */

public interface IReservaDAO extends IDAO<ReservaEntity> {
	public List<ReservaEntity> getByNome();
}
