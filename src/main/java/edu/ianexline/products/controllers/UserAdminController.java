package edu.ianexline.products.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ianexline.products.data.UsersRepository;
import edu.ianexline.products.models.UserEntity;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {

    private final UsersRepository usersRepository;

    public UserAdminController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "userAdmin";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model, RedirectAttributes redirect) {
        Optional<UserEntity> user = usersRepository.findById(id);
        if (user.isEmpty()) {
            redirect.addFlashAttribute("message", "User not found.");
            return "redirect:/admin/users";
        }
        model.addAttribute("user", user.get());
        return "editUser";
    }

    @PostMapping("/edit")
    public String saveEdit(
            @RequestParam("id") Integer id,
            @RequestParam("role") String role,
            @RequestParam(name = "enabled", defaultValue = "false") boolean enabled,
            RedirectAttributes redirect) {

        Optional<UserEntity> found = usersRepository.findById(id);
        if (found.isEmpty()) {
            redirect.addFlashAttribute("message", "User not found.");
            return "redirect:/admin/users";
        }

        if (!role.equals("USER") && !role.equals("ADMIN")) {
            redirect.addFlashAttribute("message", "Invalid role.");
            return "redirect:/admin/users";
        }

        // Only role and enabled can change here. The password is never edited.
        UserEntity user = found.get();
        user.setRole(role);
        user.setEnabled(enabled);
        usersRepository.save(user);

        redirect.addFlashAttribute("message", "User updated.");
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") Integer id, Model model, RedirectAttributes redirect) {
        Optional<UserEntity> user = usersRepository.findById(id);
        if (user.isEmpty()) {
            redirect.addFlashAttribute("message", "User not found.");
            return "redirect:/admin/users";
        }
        model.addAttribute("user", user.get());
        return "confirmDeleteUser";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer id, RedirectAttributes redirect) {
        usersRepository.deleteById(id);
        redirect.addFlashAttribute("message", "User deleted.");
        return "redirect:/admin/users";
    }
}