import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatepromotionformComponent } from './createpromotionform.component';

describe('CreatepromotionformComponent', () => {
  let component: CreatepromotionformComponent;
  let fixture: ComponentFixture<CreatepromotionformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatepromotionformComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatepromotionformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
