import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { ServiceService } from '../Service/service.service';
import {ActivatedRoute} from '@angular/router'
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-modifier',
  templateUrl: './modifier.component.html',
  styleUrls: ['./modifier.component.scss']
})
export class ModifierComponent implements OnInit {
  ModifierUtilisateur = new FormGroup({
    nom : new FormControl(''),
    prenom : new FormControl(''),
    age : new FormControl(''),
    telephone : new FormControl(''),
    email : new FormControl(''),
    login : new FormControl(''),
    password : new FormControl(''),
    genre : new FormControl(''),
    status_utilisateur : new FormControl(''),
    profil : new FormControl(''),


  })

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,private service: ServiceService, private route : ActivatedRoute) {}

  ngOnInit(){
    this.service.User(this.route.snapshot.params.id).subscribe((result: any)=>{
      this.ModifierUtilisateur = new FormGroup({
        nom : new FormControl(result['nom']),
        prenom : new FormControl(result['prenom']),
        age : new FormControl(result['age']),
        telephone : new FormControl(result['telephone']),
        email : new FormControl(result['email']),
        login : new FormControl(result['login']),
        password : new FormControl(result['password']),
        genre : new FormControl(result['genre']),
        status_utilisateur : new FormControl(result['status_utilisateur']),
        profil : new FormControl(result['profil']),
      }

      );

    })
  }
  modifier(){
    this.service.modifierUser(this.route.snapshot.params.id,this.ModifierUtilisateur.value).subscribe((resul:any)=>{

    })
  }
}
