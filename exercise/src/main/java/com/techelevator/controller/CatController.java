package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path="/api/cards")
@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<CatCard> listAllCards(){
        return catCardDao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard getCatCard(@PathVariable long id){
        return catCardDao.get(id);
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard randomCard(){
        return catCardDao.randomGet(catFactService.getFact(),catPicService.getPic());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createCard(@Valid @RequestBody CatCard catCard){
        catCardDao.save(catCard);
    }

    @RequestMapping(path= "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCard(@PathVariable long id,@Valid @RequestBody CatCard catCard) throws CatCardNotFoundException {
        catCardDao.update(id,catCard);
    }

    @RequestMapping(path= "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCard(@PathVariable long id){
        catCardDao.delete(id);
    }



}
