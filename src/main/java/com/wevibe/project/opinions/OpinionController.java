package com.wevibe.project.opinions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opinions")
public class OpinionController {

    @Autowired
    OpinionRepository opinionRepository;

    @GetMapping("")
    public List<Opinion> getAll() {
        return opinionRepository.getAll();
    }

    @GetMapping("/user={idUser}")
    public List<Opinion> getAllByUserId(@PathVariable("idUser") Long idUser) {
        return opinionRepository.getAllByUserId(idUser);
    }

    @GetMapping("/event={idEvent}")
    public List<Opinion> getAllByEventId(@PathVariable("idEvent") Long idEvent) {
        return opinionRepository.getAllByEventId(idEvent);
    }

    @GetMapping("/{id}")
    public Opinion getById(@PathVariable("id") Long id) {
        return opinionRepository.getOpinionById(id);
    }


    @PostMapping("")
    public int add(@RequestBody List<Opinion> opinions) {
        return opinionRepository.save(opinions);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Opinion updatedOpinion) {
        Opinion opinion = opinionRepository.getOpinionById(id);

        if (opinion != null) {
            opinion.setRating(updatedOpinion.getRating());
            opinion.setDescription(updatedOpinion.getDescription());
            opinion.setIdOpinionAuthor(updatedOpinion.getIdOpinionAuthor());
            opinion.setOpinionTime(updatedOpinion.getOpinionTime());
            opinion.setIdEvent(updatedOpinion.getIdEvent());

            opinionRepository.update(opinion);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") Long id, @RequestBody Opinion updatedOpinion) {
        Opinion opinion = opinionRepository.getOpinionById(id);

        if (opinion != null) {
            if (updatedOpinion.getRating() != null) opinion.setRating(updatedOpinion.getRating());
            if (updatedOpinion.getDescription() != null) opinion.setDescription(updatedOpinion.getDescription());
            if (updatedOpinion.getIdOpinionAuthor() != null)
                opinion.setIdOpinionAuthor(updatedOpinion.getIdOpinionAuthor());
            if (updatedOpinion.getOpinionTime() != null) opinion.setOpinionTime(updatedOpinion.getOpinionTime());
            if (updatedOpinion.getIdEvent() != null) opinion.setIdEvent(updatedOpinion.getIdEvent());

            opinionRepository.update(opinion);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return opinionRepository.delete(id);
    }


}
