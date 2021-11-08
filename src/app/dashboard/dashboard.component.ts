import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export default class DashboardComponent implements OnInit {
  items:any;
  isAuth = false;
  Aujor = new Date();
  formateur: any;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private service: ServiceService) {}

  ngOnInit(){

    this.service.listapprenant().subscribe((data:any) =>{
      this.items=data,
      // this.items=data.length
      // this.apprena=data.length,
      console.log(this.items.length)

    })
    this.service.listformateur().subscribe((dataa:any)=>{
      this.formateur=dataa,
      console.log(this.formateur.length)
    })
}


}
