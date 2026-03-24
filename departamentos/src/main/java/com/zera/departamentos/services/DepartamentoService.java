package com.zera.departamentos.services;

import com.zera.departamentos.models.DepartamentoModel;
import com.zera.departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel ){
        return departamentoRepository.save(departamentoModel);
    }

    public List<DepartamentoModel> buscarTodosDepartamentos(){
        return departamentoRepository.findAll();
    }

    public DepartamentoModel buscarPorId(Long id){
        return departamentoRepository.findById(id).get();
    }

    public void deletar(Long id){
        departamentoRepository.deleteById(id);
    }

    public DepartamentoModel atualizar(Long id, DepartamentoModel departamentoModel){
        DepartamentoModel newDepartamento = departamentoRepository.findById(id).get();
        newDepartamento.setNome(departamentoModel.getNome());
        newDepartamento.setLocalizacao(departamentoModel.getLocalizacao());
        return departamentoRepository.save(newDepartamento);
    }

}
