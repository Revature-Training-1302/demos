import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PipeExampleComponent } from './pipe-example/pipe-example.component';
import { CustomPipePipe } from './custom-pipe.pipe';
import { ChildComponent } from './child/child.component';
import { ParentComponent } from './parent/parent.component';
import { SubjectExampleComponent } from './subject-example/subject-example.component';
import { DinosComponent } from './dinos/dinos.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PipeExampleComponent,
    CustomPipePipe,
    ChildComponent,
    ParentComponent,
    SubjectExampleComponent,
    DinosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
