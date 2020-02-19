package dev.eastar.mvc.user

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@WebMvcTest(UserController::class)
class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun hello() {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect { MockMvcResultMatchers.status().isOk }
                .andExpect { MockMvcResultMatchers.content().string("hello") }
    }

    @Test
    fun createUser_JSON() {
        val userJson = """{"username":"eastar", "password":"123"}"""
        mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", `is`(equalTo("eastar"))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", `is`(equalTo("123"))))
    }

    @Test
    fun createUser_XML() {
        val userJson = """{"username":"eastar", "password":"123"}"""
        mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.xpath("/User/username").string("eastar"))
                .andExpect(MockMvcResultMatchers.xpath("/User/password").string("123"))
    }

}