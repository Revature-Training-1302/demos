import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// Imported the instructions component automatically for us
import { InstructionsComponent } from './instructions/instructions.component';
import { PetComponent } from './pet/pet.component';
import { PetsComponent } from './pets/pets.component';
import { AddPetComponent } from './add-pet/add-pet.component';
import { StyleTestComponent } from './style-test/style-test.component';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';

// set up our routes:
const routes:Routes = [
  // when go to /pets, we want to display the PetsComponent
  {path: 'pets', component: PetsComponent},
  {path: 'add', component: AddPetComponent},
  {path: 'pet', component: PetComponent},
  {path: 'instructions', component: InstructionsComponent}
]

@NgModule({
  // we need to declare all of our components in this array:
  declarations: [
    AppComponent,
    InstructionsComponent,
    PetComponent,
    PetsComponent,
    AddPetComponent,
    StyleTestComponent,
    NavbarComponent
  ],
  // whatever modules we need to import, we'll include those in this array:
  imports: [
    BrowserModule,
    AppRoutingModule,
    // lets us use the ngModel for 2-way binding
    FormsModule,
    // configure the router module to use the routes that we defined above:
    RouterModule.forRoot(routes)
  ],
  providers: [],
  // root component of the app:
  bootstrap: [AppComponent]
})
export class AppModule { }
