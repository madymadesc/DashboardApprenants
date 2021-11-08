import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  [x: string]: any;
  items:any;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private serv: ServiceService) {}

  ngOnInit(){
    this.Listutilisateur()

  }
  Listutilisateur(){
    this.serv.listUtilisateur().subscribe((data:any) =>{
      this.items=data,
      console.log(data)
    });
  }
  suprime(id:any){
    this.serv.suprime(id).subscribe(data=>{
      console.log(data)
      this.Listutilisateur()
    })
  }
  // user(id:any){
  //   this.serv.User(id).subscribe(data=>{

  //   })
  // }

}
