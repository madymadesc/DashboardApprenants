import { Component,OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-presence',
  templateUrl: './presence.component.html',
  styleUrls: ['./presence.component.scss']
})
export class PresenceComponent implements OnInit {
  items:any;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(
    private breakpointObserver: BreakpointObserver,
    private serv: ServiceService
    ) {}

  ngOnInit(){
    this.Listutilisateur()


  }
  Listutilisateur(){
    this.serv.listapprenant().subscribe((data:any) =>{
      this.items=data,
      // this.items=data.length
      console.log(data.length)

    });
  }
}
