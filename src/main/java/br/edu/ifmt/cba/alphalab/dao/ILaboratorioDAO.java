package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;

/**
 * 
 * @author St�villis Sousa
 *
 */

public interface ILaboratorioDAO extends IDAO<LaboratorioEntity> {
	LaboratorioEntity getByNome(String nome);
}