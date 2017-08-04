package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IDepartamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.software.MockSoftwareDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

public class MockDepartamentoDAO implements IDepartamentoDAO {
	private static ArrayList<DepartamentoEntity> listaDepartamentos = new ArrayList();
	private static MockDepartamentoDAO singleton = null;

	private static final DepartamentoEntity departamento1= new DepartamentoEntity();
        private static final DepartamentoEntity departamento2= new DepartamentoEntity();

	static {
		departamento1.setId(1L);
		departamento1.setSigla("DAI");
		departamento1.setNome("Departamento da �rea de Inform�tica");
		departamento1.setObservacao("Inform�tica");
		departamento1.setChefe(MockServidorDAO.getInstance().servidor1);

		listaDepartamentos.add(departamento1);
                
                
                departamento2.setId(1L);
		departamento2.setSigla("DACC");
		departamento2.setNome("Departamento da �rea de Consta��o Civil");
		departamento2.setObservacao("Constru��o Civil");
		departamento2.setChefe(
				(ServidorEntity) MockServidorDAO.getInstance().getByNome("�ngela de Oliveira").toArray()[0]);

		listaDepartamentos.add(departamento2);
	}

	public static MockDepartamentoDAO getInstance() {
		if (singleton == null)
			singleton = new MockDepartamentoDAO();

		return singleton;
	}

	@Override
	public List<DepartamentoEntity> buscarTodos() {
		return listaDepartamentos;
	}

	@Override
	public void save(DepartamentoEntity entity) {
		if (listaDepartamentos.indexOf(entity) < 0)
			listaDepartamentos.add(entity);
	}

	@Override
	public void delete(DepartamentoEntity entity) {
		listaDepartamentos.remove(entity);
	}

	@Override
	public DepartamentoEntity getById(Long id) {
		for (DepartamentoEntity vo : listaDepartamentos)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public DepartamentoEntity getbySigla(String sigla) {
		if (listaDepartamentos.indexOf(sigla) < 0)
			return null;
		else
			return listaDepartamentos.get(listaDepartamentos.indexOf(sigla));
	}
}
