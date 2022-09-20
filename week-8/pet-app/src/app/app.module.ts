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

@NgModule({
  // we need to declare all of our components in this array:
  declarations: [
    AppComponent,
    InstructionsComponent,
    PetComponent,
    PetsComponent,
    AddPetComponent
  ],
  // whatever modules we need to import, we'll include those in this array:
  imports: [
    BrowserModule,
    AppRoutingModule,
    // lets us use the ngModel for 2-way binding
    FormsModule
  ],
  providers: [],
  // root component of the app:
  bootstrap: [AppComponent]
})
export class AppModule { }
