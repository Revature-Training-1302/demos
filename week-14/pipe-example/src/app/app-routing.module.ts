import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExerciseComponent } from './exercise/exercise.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  // if we go /home, we're going to see the HomeComponent
  {path: "home", component: HomeComponent},
  {path: "exercise", component:ExerciseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
