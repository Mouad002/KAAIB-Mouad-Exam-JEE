import { Component } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Client } from '../model/client.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ClientService } from '../services/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clients',
  standalone: false,
  templateUrl: './clients.component.html',
  styleUrl: './clients.component.css'
})
export class ClientsComponent {
  clients!: Observable<Array<Client>>;
  errorMessage!: string;
  searchFormGroup!: FormGroup;
  constructor(private clientService: ClientService, private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control("")
    });
    this.getClients();
  }

  getClients() {
    this.clients = this.clientService.getAllClients().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err)
      })
    );
  }

  handleClientClick(client: Client) {
    this.router.navigateByUrl('/client-accounts/'+client.id, {state: client});
  }
}
