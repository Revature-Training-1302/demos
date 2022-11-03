import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentDynamic } from './component-dynamic/component-dynamic.component';
import { DinosaurComponent } from './dinosaur/dinosaur.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentDynamic,
    DinosaurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  // with manual bootstrapping, we have to specify which component(s) could be bootstrapped)
  entryComponents: [ComponentDynamic, DinosaurComponent]
  // bootstrap: [AppComponent]
})
export class AppModule { 
  // with manual bootstrapping, we have to manually fill out this method:
  ngDoBootstrap(app:any) {
    // first, get the element from the index.html
    const dynamicComponentElement = document.querySelector('#dynamicComponentElement');
    // specify that we have loaded the element:
    dynamicComponentElement!.textContent = 'Loaded';

    // because we bootstrap the element using TypeScript, we could also get this from some server, or anywhere
    // in this case, let's use the Math library to randomly bootstrap either component:
    if(Math.random() < 0.5) {
      // create an element using the selector that was defined in the dynamic component
      const componentElement = document.createElement('d-comp');
      // add this component to the page
      document.body.appendChild(componentElement);
      // finally, bootstrap the app with this component
      app.bootstrap(ComponentDynamic);
    } else {
      const componentElement = document.createElement('app-dinosaur');
      document.body.appendChild(componentElement);
      app.bootstrap(DinosaurComponent);
    }
  }
}
