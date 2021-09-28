package br.com.api.ibyte.auth;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.api.ibyte.application.auth.interfaces.services.IUsersAppService;
import br.com.api.ibyte.service.api.auth.UserController;

/**
 *
 * @author marcos.oliveira
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UsersWebApiTest {
    @MockBean
    IUsersAppService peopleService;
     
    ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "{security.usernames}", password = "{security.password}", roles = "USER")
    public void getAllTest()  throws Exception  {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}