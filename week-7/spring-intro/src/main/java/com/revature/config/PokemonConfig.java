package com.revature.config;

import com.revature.entity.Pokemon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// this class contains methods that produce beans
// beans - Java objects that are managed by Spring's IoC (Inversion of Control) container
@Configuration
@Import(BerryConfig.class) // we can import bean-producing methods from another configuration class
public class PokemonConfig {

    // this method is annotated with the Bean annotation, meaning that the object is returns will
    // be managed by the IoC:
    @Bean(name = "random", initMethod = "init", destroyMethod = "destroy") // configure our custom lifecycle methods
    @Scope("prototype")// will allow us to have multiple instances of the Pokemon object from this method:
    public Pokemon getRandomPokemon() {
        System.out.println("This random pokemon method was called");
        List<String> names = new ArrayList<>();
        names.add("Bulbasaur");
        names.add("Charmander");
        names.add("Squirtle");

        Random generator = new Random();

        String name = names.get(generator.nextInt(3)); // return a random element from the names list

        String type1 = "type1";
        String type2 = "type2";

        int level = 5;

        // this Pokemon object will be registered as a bean:
        return new Pokemon(name, name, type1, type2, level);
    }

    @Bean(name = "regular")
    public Pokemon getPokemon() {
        return new Pokemon("pickachu", "pika", "electric", "mouse", 5);
    }


    // wouldn't need @Bean here because we're not returning an object to be registered as a bean:
    public void helper() {
        System.out.println("Helping");
    }

}
