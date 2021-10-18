import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-question-update',
  templateUrl: './question-update.component.html',
  styleUrls: ['./question-update.component.css']
})
export class QuestionUpdateComponent implements OnInit {

  public Editor:any = ClassicEditor;

  quesId:any;
  question:any = [];

  constructor(
    private _route: ActivatedRoute,
    private _question: QuestionService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.quesId = this._route.snapshot.params.quesId;
    this._question.getSingleQuestion(this.quesId).subscribe(
      (data: any) => {
        this.question = data;
        //console.log(this.question);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  formSubmit() {
    if (this.question.content.trim() == '' || this.question.content == null) {
      return;
    }

    if (this.question.option1.trim() == '' || this.question.option1 == null) {
      return;
    }
    if (this.question.option2.trim() == '' || this.question.option2 == null) {
      return;
    }
    if (this.question.answer.trim() == '' || this.question.answer == null) {
      return;
    }

    //form submit
    this._question.updateQuestion(this.question).subscribe(
      (data: any) => {
        Swal.fire('Success ', 'Question Updated', 'success');
        this.location.back();

      },
      (error) => {
        Swal.fire('Error', 'Error in updating question', 'error');
      }
    );
  }
}