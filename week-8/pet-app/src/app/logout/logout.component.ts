import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private cookieService:CookieService,
    private router:Router) { }

  ngOnInit(): void {
    this.cookieService.removeAll();
    this.router.navigate(["/pets"]);
  }

}
