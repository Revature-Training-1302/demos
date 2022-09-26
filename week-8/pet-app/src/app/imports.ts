import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { CookieModule, CookieService } from "ngx-cookie";

export const modules = [HttpClientModule, BrowserModule, FormsModule, CookieModule.withOptions(),];
export const services = [];