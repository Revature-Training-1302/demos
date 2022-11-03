import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AttributeDirectivesComponent } from './attribute-directives/attribute-directives.component';
import { ComponentDirectiveComponent } from './component-directive/component-directive.component';
import { ExerciseComponent } from './exercise/exercise.component';
import { StructuralDirectivesComponent } from './structural-directives/structural-directives.component';

const routes: Routes = [
  {path: "comp", component:ComponentDirectiveComponent},
  {path: "struct", component:StructuralDirectivesComponent},
  {path: "att", component:AttributeDirectivesComponent},
  {path: "exercise", component:ExerciseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
