package digytal.myfriends.restapi.controller;

import digytal.myfriends.restapi.dto.FriendDto;
import digytal.myfriends.restapi.model.Friend;
import digytal.myfriends.restapi.model.Address;
import digytal.myfriends.restapi.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/friends")
public class FriendController {
    @Autowired
    private FriendService service;
    @PostMapping
    public ResponseEntity post(@RequestBody FriendDto cliente){
        return new ResponseEntity<>(service.save(cliente), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Integer id, @RequestBody FriendDto cliente){
        service.update(id,cliente);
        return ResponseEntity.ok().body(null);
    }
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchByNome( @RequestParam(required = false) String name,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "3") int size){
        Page<Friend> pageFriend = service.pagination(name, page,size);
        Map<String, Object> response = new HashMap<>();
        response.put("friends", pageFriend.getContent());
        response.put("currentPage", pageFriend.getNumber());
        response.put("totalItems", pageFriend.getTotalElements());
        response.put("totalPages", pageFriend.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity <List<Friend>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(service.findOne(id));
    }
    @GetMapping("/{id}/address")
    public ResponseEntity getAddress(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(service.findEndereco(id));
    }
    @PatchMapping("/{id}/address")
    public ResponseEntity updateAddress(@PathVariable("id") Integer id, @RequestBody Address address){
        service.updateEndereco(id, address);
        return ResponseEntity.ok().body(null);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }

}
