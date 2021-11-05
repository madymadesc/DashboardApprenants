import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { NgForm } from '@angular/forms';
import { ServiceService } from '../Service/service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.component.html',
  styleUrls: ['./ajouter.component.scss']
})
export class AjouterComponent implements OnInit {
  [x: string]: any;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(
    private breakpointObserver: BreakpointObserver,
    private serv:ServiceService,
    private route : ActivatedRoute)
    {}
    // ajouterUtilisateur = new FormGroup({
    //   nom:new FormControl(''),
    //   prenom:new FormControl(''),
    //   age:new FormControl(''),
    //   telephone:new FormControl(''),
    //   email:new FormControl(''),
    //   login:new FormControl(''),
    //   password:new FormControl(''),
    //   genre:new FormControl(''),
    //   status:new FormControl(''),
    //   profile:new FormControl(''),
    //   dateCreation:new FormControl(''),
    //   dateModification:new FormControl(''),
    // }
    // );
  ngOnInit():void {

  }
  SaveData(form: NgForm){
    var transformJson= JSON.stringify(this.serv.ajouterApprenant(form.value));
    var add= JSON.parse(transformJson);
    console.log(add);
    return add;
  }



}
