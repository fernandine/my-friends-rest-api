package digytal.myfriends.restapi.service;

import digytal.myfriends.restapi.dto.FriendDto;
import digytal.myfriends.restapi.infra.exceptions.RecordNotFoundException;
import digytal.myfriends.restapi.model.Friend;
import digytal.myfriends.restapi.model.Address;
import digytal.myfriends.restapi.repository.FriendRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FriendRepository repository;
    public Page<Friend> pagination(String name, int page, int size){
        Pageable paging = PageRequest.of(page, size);
        Page<Friend> clientes=null;
        if(name==null || name.isEmpty())
            clientes= repository.findAll(paging);
        else
            clientes= repository.findByNameContaining(name,paging);

        return clientes;
    }
    public List<Friend> findAll(){
        return repository.findAll();
    }

    /*
    Serve para o endpoint, quanto recursos do serviço
     */
    public Friend findOne(Integer id){
        Friend friend = repository.findById(id).orElse(null);
        if(friend ==null)
            throw  new RecordNotFoundException(id);
        return friend;
    }
    public Address findEndereco(Integer id){
        return findOne(id).getAddress();
    }
    public Integer save(FriendDto cliente){
        Friend entity = modelMapper.map(cliente, Friend.class);
        repository.saveAndFlush(entity);
        return entity.getId();
    }
    public void update(Integer id, FriendDto cliente){
        Friend entity = findOne(id);
        if(entity!=null){
            entity = modelMapper.map(cliente, Friend.class);
            entity.setId(id);
            repository.save(entity);
        }
    }
    public void updateEndereco(Integer id, Address address){
        Friend entity = findOne(id);
        if(entity!=null){
           entity.setAddress(address);
            repository.save(entity);
        }
    }
    public void delete(Integer id){
        Friend entity = findOne(id);
        repository.delete(entity);
    }
}
