package sheridan.muskan38.assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/", "/pets"})
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "list";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("pet", new Pet());
        return "form";
    }

    @PostMapping
    public String save(@ModelAttribute("pet") @Valid Pet pet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        petService.savePet(pet);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Pet pet = petService.getPetById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pet ID: " + id));
        model.addAttribute("pet", pet);
        return "form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("pet") @Valid Pet pet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        pet.setId(id);
        petService.savePet(pet);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        petService.deletePet(id);
        return "redirect:/";
    }
}
