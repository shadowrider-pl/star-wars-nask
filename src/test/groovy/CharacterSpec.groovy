
import com.finbarre.starwarsnask.payload.Character;
import com.finbarre.starwarsnask.controller.CharacterResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterSpec extends spock.lang.Specification{


    @Autowired (required = false)
    private CharacterResource characterResource;


    @Autowired
    private MockMvc mvc

        def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response.contentAsString == "Hello world!"
    }

    def "when set and delete are performed then the response has status 204 and content changes as expected"() {
        given: "a new name"
        def NAME = "Emmy"

        when: "the name is set"
        mvc.perform(MockMvcRequestBuilders.put("/hello").content(NAME)).andExpect(MockMvcResultMatchers.status().isNoContent())

        then: "the salutation uses the new name"
        mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response.contentAsString == "Hello $NAME!"

        when: "the name is deleted"
        mvc.perform(MockMvcRequestBuilders.delete("/hello")).andExpect(MockMvcResultMatchers.status().isNoContent())

        then: "the salutation uses the default name"
        mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response.contentAsString == "Hello world!"
    }

    def "when context is loaded then all expected beans are created"() {
        expect: "the CharacterResource is created"
        characterResourceeeee
    }

    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(get("/hello3333"))
          .andExpect(status().isOk())
          .andReturn()
          .response
          .contentAsString == "Hello world!4444444444"
    }

  // public void "customer full name is formed from first name and last name"() {
  //   given: "a customer with example name values"
  //   Character sampleCustomer = new Character()
  //   sampleCustomer.setName("Luke Skywalker")
    
  //   and: "an entity manager that always returns this customer"
  //   EntityManager entityManager = Stub(EntityManager.class)
  //   entityManager.find(Customer.class,1L) >> sampleCustomer
    
  //   and: "a customer reader which is the class under test"
  //   CustomerReader customerReader = new CustomerReader()
  //   customerReader.setEntityManager(entityManager)
    
  //   when: "we ask for the full name of the customer"
  //   String fullName = customerReader.findFullName(1L)
  
  //   then: "we get both the first and the last name"
  //   fullName == "Susan Ivanova"
  // }

}