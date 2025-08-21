package org.example.Service;

import org.example.repository.BaseRepository;

import java.util.List;

public abstract class BaseService<T> {

    protected BaseRepository<T> repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public T create(T element){
        return repository.create(element);
    }
    public T update (T element) {
        return repository.update(element);

    }
    boolean delete (int id){
        T element = findById(id);
        return repository.delete(element);
    }
    public List<T> findAll (){
        return repository.findAll();
    }
    public T findById(int id){
        return  repository.findById(id);
    }
}
