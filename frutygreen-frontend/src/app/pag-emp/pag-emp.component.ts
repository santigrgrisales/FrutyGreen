import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-pag-emp',
  standalone: true,
  imports: [RouterOutlet, CommonModule,FormsModule],
  templateUrl: './pag-emp.component.html',
  styleUrl: './pag-emp.component.css'
})
export class PagEmpComponent {

}
